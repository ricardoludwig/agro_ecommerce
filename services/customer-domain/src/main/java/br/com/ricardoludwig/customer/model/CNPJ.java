package br.com.ricardoludwig.customer.model;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public final class CNPJ extends Document {

	private final String _id;
	private final CNPJValidator _cnpjValidator;
	private final boolean _valid;

	public static enum EnumCNPJ {
		CNPJ;
		public static String value() {
			EnumCNPJ[] values = values();
			return values[0].toString();
		}
	}
	
	public CNPJ(String id) {
		_cnpjValidator = new CNPJValidator();
		if (isValid(id)) {
			_id = id;
			_valid = true;
		} else {
			_id = "";
			_valid = false;
		}
	}

	@Override
	public String getNumber() {
		return _id;
	}

	@Override
	public boolean isValid() {
		return _valid;
	}

	boolean isValid(String id) {
		if (id == null) {
			return false;
		}

		boolean inelegible =  !_cnpjValidator.isEligible(id);
		if (inelegible) {
			return false;
		}
		
		try {
			_cnpjValidator.assertValid(id);
			return true;
		} catch (InvalidStateException e) {
			return false;
		}
	}

}
