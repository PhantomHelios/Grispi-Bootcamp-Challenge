package com.kodgemisi.usermanagement;

/**
 * Represents a phone number, never stores a null value. If constructed with a null value stores an empty string.
 */
public class Phone implements CharSequence {

	private final String phoneNumber;

	public Phone(String phoneNumber) {

		if (!isValid(phoneNumber)){
			throw new IllegalArgumentException("Phone number does not adhere the requirements");
		}

		this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
	}

	public String number() {
		return phoneNumber;
	}

	@Override
	public int length() {
		return phoneNumber.length();
	}

	@Override
	public char charAt(int index) {
		return phoneNumber.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return phoneNumber.subSequence(start, end);
	}

	@Override
	public String toString() {
		return phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Phone phone = (Phone) o;

		return phoneNumber.equals(phone.phoneNumber);
	}

	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}

	private boolean isValid(String phoneNumber){
        if (phoneNumber == null || phoneNumber.equals("")){
            return false;
        }

        if (phoneNumber.subSequence(0, 1).equals("+")){

            if(phoneNumber.length() > 3 && phoneNumber.subSequence(1, 3).equals("90")){
                return phoneNumber.length() == 13;
            }

            if(phoneNumber.length() >= 5){
                return true;
            }
        }

        if (phoneNumber.equals("112") || phoneNumber.equals("911")){
            return true;
        }

        return false;
    }
}
