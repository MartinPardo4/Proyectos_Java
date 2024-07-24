package UI;

import java.util.List;
import javax.swing.*;
import Entidades.Turno;
import Service.*;

public class TablaTurnosPanel extends TablaPanel{
	
	private JTable tablaTurnos;
	private ModeloTablaTurnos modelo;
	private JScrollPane scrollPane;
	private List<Turno> listaTurnos;
	
	public TablaTurnosPanel(UIManager manager) {
		super(manager);
	}
	
	public void crearTablaPanel() {
		
		modelo = new ModeloTablaTurnos();
		tablaTurnos = new JTable(modelo);
		scrollPane = new JScrollPane(tablaTurnos);
		this.add(scrollPane);
		
		try {
			TurnoService service = new TurnoService();
			listaTurnos = service.enlistarTurno();
			modelo.setTurnos(listaTurnos); 
			modelo.fireTableDataChanged();
		}catch(EnlistarException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		modelo.filtrarTablaPorNombre("");
		
	}

	public JTable getTablaTurnos() {
		return tablaTurnos;
	}

	public void setTablaTurnos(JTable tablaTurnos) {
		this.tablaTurnos = tablaTurnos;
	}

	public ModeloTablaTurnos getModelo() {
		return modelo;
	}

	public void setModelo(ModeloTablaTurnos modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public List<Turno> getListaTurnos() {
		return listaTurnos;
	}

	public void setListaTurnos(List<Turno> listaTurnos) {
		this.listaTurnos = listaTurnos;
	}
	
	
}
