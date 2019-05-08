package contracts;

public class PreconditionError extends ContractError {
	public PreconditionError(String message) {
		super("Precondition failed: "+message);
	}
}
