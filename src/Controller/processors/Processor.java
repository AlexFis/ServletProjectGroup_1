package Controller.processors;

import model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public abstract class Processor {
    protected String action;

    public boolean canProcess(String actionToProcess) {
        return actionToProcess.equals(action);
    }

    public abstract ProcessorResult getResult(HttpServletRequest request);
}
