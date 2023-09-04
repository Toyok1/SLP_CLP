package sem_an;

public class simpLanPlusError extends RuntimeException
{
    private String m = "err";

    public simpLanPlusError(String message)
    {
        this.m = message;
    }

    @Override
    public String getMessage() {
        return m;
    }
}
