package fr.inti.convertisseur;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


import fr.inti.ManagedBean.EtudiantManagedBean;
import fr.inti.entities.Etudiant;

public class ConvertisseurEtudiant implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String etudiantId) {
		ValueExpression vex = 
				ctx.getApplication().getExpressionFactory()
				.createValueExpression(ctx.getELContext(),
				"#{etudiantMB}", EtudiantManagedBean.class);
		
		EtudiantManagedBean etudiant = (EtudiantManagedBean)vex.getValue(ctx.getELContext());
		
		
		
		return  etudiant.getEtudiant(Integer.valueOf(etudiantId));
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object etudiant) {

		String s = String.valueOf(((Etudiant)etudiant).getId());
		
		return s;
	}

}
