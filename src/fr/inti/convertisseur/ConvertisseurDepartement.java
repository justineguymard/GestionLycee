package fr.inti.convertisseur;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fr.inti.ManagedBean.DepartementManagedBean;
import fr.inti.entities.Departement;

public class ConvertisseurDepartement implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String departementId) {
		ValueExpression vex = 
				ctx.getApplication().getExpressionFactory()
				.createValueExpression(ctx.getELContext(),
				"#{departementMB}", DepartementManagedBean.class);
		
		DepartementManagedBean departement= (DepartementManagedBean) vex.getValue(ctx.getELContext());
		
		
		
		return  departement.getDepartement(Integer.valueOf(departementId));
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object departement) {
		
		String s= String.valueOf(((Departement)departement).getId());
		
		return s;
	}
}
