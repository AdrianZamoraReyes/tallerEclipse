package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitService;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private VisitService visitService;
	
	public List<Bill> findAll() {
		List<Bill> lista = this.billRepository.findAll();
		return lista;
	}
	
	public Bill findById(Integer id) {
		return this.billRepository.findOne(id);
	}
	
	public Bill save(Bill b) {
		return billRepository.save(b);
	}
	
	public void deleteBill(Bill b) {
		this.billRepository.delete(b);;
	}
	
	public void deleteAll() {
		this.billRepository.deleteAll();
	}
	
	public List<Bill> getBillByVisit(boolean pagadas) {
		if (pagadas)
			return this.billRepository.getBillByVisitNotNull();
		else
			return this.billRepository.getBillByVisitNull();
	}

	public Visit findVisit(Integer idBill, Integer idVisit) {
		Visit v=null;
		
		Bill fromDB = this.findById(idBill);
		if(fromDB != null)
			if(fromDB.getVisit() != null && fromDB.getVisit().getId().equals(idVisit))
				v = fromDB.getVisit();
		
		return v;
	}
	
	public Bill updateBillWithVisit(Integer idBill, Integer idVisit) {
		Visit v = findVisit(idBill, idVisit);
		Bill b = this.billRepository.findOne(idBill);
		if(b != null) {
			if(v != null) {
				v.setBill(b);
				visitService.save(v);
				b.setVisit(v);
				billRepository.save(b);
			} else {
				v = visitService.findOne(idVisit);
				v.setBill(b);
				visitService.save(v);
				b.setVisit(v);
				billRepository.save(b);
			}	
		}
		return b;
	}
}