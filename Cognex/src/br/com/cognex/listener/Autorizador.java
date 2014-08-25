package br.com.cognex.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.cognex.bean.LoginBean;


public class Autorizador implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext context = e.getFacesContext();
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		// Obtendo LoginBean da sess�o
		LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		if (!loginBean.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
