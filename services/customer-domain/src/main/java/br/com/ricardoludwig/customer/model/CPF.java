package br.com.ricardoludwig.customer.model;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public final class CPF extends Document {

	private final String _number;
	private final CPFValidator _cpfValidator;
	private final boolean _valid;
	
	public static enum EnumCPF {
		CPF;
		public static String value() {
			EnumCPF[] values = values();
			return values[0].toString();
		}
	}

	public CPF(String id) {
		_cpfValidator = new CPFValidator();
		if (isValid(id)) {
			_number = id;
			_valid = true;
		} else {
			_number = "";
			_valid = false;
		}
	}

	@Override
	public String getNumber() {
		return _number;
	}

	@Override
	public boolean isValid() {
		return _valid;
	}
	
	public 

	boolean isValid(String id) {
		if (id == null) {
			return false;
		}
		boolean ineligible = !_cpfValidator.isEligible(id);
		if (ineligible) {
			return false;
		}

		try {
			_cpfValidator.assertValid(id);
			return true;
		} catch (InvalidStateException e) {
			return false;
		}

	}

}
