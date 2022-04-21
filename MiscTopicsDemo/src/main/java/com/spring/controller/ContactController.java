package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	/**PATH Parameter API versioning */
	
	@GetMapping(value="/api/contact/v1", produces=MediaType.APPLICATION_JSON_VALUE) //OLD API
	public Contact getContact() {
		return  new Contact("Tom",12345);
	}
	
	@GetMapping(value="/api/contact/v2", produces=MediaType.APPLICATION_JSON_VALUE) // NEW API
	public ContactV2 getContactV2() {
		return  new ContactV2("Jerry",12345);
	}
	
	/** Query/Request/ PATH Parameter API versioning */
	
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, params="version=v1") //OLD API
	public Contact getContactQueryV1() {
		return  new Contact("Tom",12345);
	}
	
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, params="version=v2") //NEW API
	public ContactV2 getContactQueryV2() {
		return  new ContactV2("Jerry",12345);
	}
	
	/** Header Parameter API versioning */

	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, headers="version=v1") //OLD API
	public Contact getContactHeaderV1() {
		return  new Contact("Tom",12345);
	}
	
	@GetMapping(value="/api/contact", produces=MediaType.APPLICATION_JSON_VALUE, headers="version=v2") //NEW API
	public ContactV2 getContactHeaderV2() {
		return  new ContactV2("Jerry",12345);
	}
	
	/** Content Negotiation based API versioning */
	
	@GetMapping(value="/api/contact", produces="application/contact.v1+json") //OLD API
	public Contact getContactContentNegoV1() {
		return  new Contact("Tom",12345);
	}
	
	@GetMapping(value="/api/contact", produces="application/contact.v2+json") //NEW API
	public ContactV2 getContactContentNegoV2() {
		return  new ContactV2("Jerry",12345);
	}
	
}

class Contact{
	private String name;
	private int mobile;
	public Contact() {
		super();
	}
	public Contact(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}
	
}


class ContactV2{
	private String name;
	private int mobileNo;
	public ContactV2() {
		super();
	}
	public ContactV2(String name, int mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
	
}