package sem_an;

public class SemanticError {
    private String msg;

    public SemanticError(String _msg) {
        msg = _msg;
    }

    public String toString() {
        return msg;
    }
}