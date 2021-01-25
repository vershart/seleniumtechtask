package vershart.techtasks;

public interface IErrorListener {
    void invoke(ExpectedConditionFailedException ex);
}
