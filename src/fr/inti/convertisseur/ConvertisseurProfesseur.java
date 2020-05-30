package fr.inti.convertisseur;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fr.inti.ManagedBean.ProfesseurManagedBean;

import fr.inti.entities.Professeur;

import javax.el.ValueExpression;

public class ConvertisseurProfesseur implements Converter{

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String professeurId) {
		ValueExpression vex = 
				ctx.getApplication().getExpressionFactory()
				.createValueExpression(ctx.getELContext(),
				"#{professeurMB}", ProfesseurManagedBean.class);
		
		ProfesseurManagedBean professeur = (ProfesseurManagedBean)vex.getValue(ctx.getELContext());
		
		
		
		return  professeur.getProfesseur(Integer.valueOf(professeurId));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object professeur) {
		
		String s = String.valueOf(((Professeur)professeur).getId());
		
		return s;
	}

}
