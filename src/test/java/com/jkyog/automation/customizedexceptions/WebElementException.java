package com.jkyog.automation.customizedexceptions;

public class WebElementException extends  Exception{
    /**
     *
     */
    private static final long serialVersionID = 1L;

    public WebElementException()
    {
        super();
    }
    public WebElementException(String exceptionMessage)
    {
        super(exceptionMessage);
    }
}
