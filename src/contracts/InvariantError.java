package contracts;

public class InvariantError extends ContractError {
	public InvariantError(String message) {
		super("Invariant failed: "+message);
	}
}
