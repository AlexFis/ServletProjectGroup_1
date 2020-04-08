package Controller.processors;

import model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor {

    public ProcessorLogOut() {
        action = "logOut";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ProcessorResult("/ServletProjectGroup_1_war_exploded/welcome","",false);
    }
}
