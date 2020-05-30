package fr.inti.convertisseur;

import javax.faces.convert.Converter;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import fr.inti.ManagedBean.MatiereManagedBean;
import fr.inti.entities.Matiere;

public class ConvertisseurMatiere implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String matiereId) {
		ValueExpression vex = 
				ctx.getApplication().getExpressionFactory()
				.createValueExpression(ctx.getELContext(),
				"#{matiereMB}", MatiereManagedBean.class);
		
		MatiereManagedBean matiere= (MatiereManagedBean) vex.getValue(ctx.getELContext());
		
		
		
		return  matiere.getMatiere(Integer.valueOf(matiereId));
		
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object matiere) {
		
		String m= String.valueOf(((Matiere)matiere).getId());
		
		return m;
	}

}
