package contracts;

public class PostconditionError extends ContractError {
	public PostconditionError(String message) {
		super("Postcondition failed: "+message);
	}
}
