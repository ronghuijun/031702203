package com.manage;

import java.util.List;

public class TotalInfo {
	List<UserInfo> addressBook;

	public List<UserInfo> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List<UserInfo> addressBook) {
		this.addressBook = addressBook;
	}

	@Override
	public String toString() {
		return "TotalInfo [addressBook=" + addressBook + "]";
	}
	
	
}
