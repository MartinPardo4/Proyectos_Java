package UI;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import java.util.*;
import Entidades.*;
import Service.*;


public class UIManager {
	
	private Dimension originalSize;
	private BotoneraPanel panelBotonera;
	private CamposFormularioMedicoPanel panelCamposMedico;
	private CamposFormularioPacientePanel panelCamposPaciente;
	private CampoFechaTurnoPanel panelCamposTurnos;
	private AgregarMedicoPanel panelAgergarMedico;
	private AgregarPacientePanel panelAgregarPaciente;
	private AgregarTurnoPanel panelAgregarTurno;
	private LogInPanel panelLogIn;
	private PantallaTablaMedicos pantallaTablaMedicos;
	private PantallaTablaPacientes pantallaTablaPacientes;
	private PantallaTablaTurnos pantallaTablaTurnos;
	private RegistrarUsuarioPanel panelRegistrarUsuario;
	private EditarMedicoPanel panelEditarMedico;
	private EditarPacientePanel panelEditarPaciente;
	private EditarTurnoPanel panelEditarTurno;
	private ListaMedicosPanel panelListaMedicos;
	private ListaPacientesPanel panelListaPacientes;
	private ListaTurnosPorFechaPanel panelListaTurnosPorFecha;
	private HomePanel panelHome;
	private MenuTablasPanel panelMenuTablas;
	private ConsultaTurnosPanel panelConsultaTurnos;
	private SeleccionFechasPanel panelSeleccionFechas;
	private ReportePanel panelReporte;
	private JFrame frame;
	private List<Usuario> listaUsuarios;
	private List<Medico> listaMedicos;
	
	public UIManager() {
		
	}
	
	public void crearManager() {
		
		MedicoService medicoService = new MedicoService();
		try {
			medicoService.armarTabla();
		}catch(TablaException e) {
			System.out.println(e.getMessage());
		}
		
		PacienteService pacienteService = new PacienteService();
		try {
			pacienteService.armarTabla();
		}catch(TablaException e) {
			System.out.println(e.getMessage());
		}
		
		TurnoService turnoService = new TurnoService();
		try {
			turnoService.armarTabla();
		}catch(TablaException e) {
			System.out.println(e.getMessage());
		}
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,470);
		originalSize = frame.getSize();
		frame.setLocationRelativeTo(null);
		
		panelBotonera = new BotoneraPanel(this);
		
		panelCamposMedico = new CamposFormularioMedicoPanel(this);
		
		panelCamposPaciente = new CamposFormularioPacientePanel(this);
		
		panelCamposTurnos = new CampoFechaTurnoPanel(this);
		
		panelLogIn = new LogInPanel(this);
		
		panelHome = new HomePanel(this);
		
		panelMenuTablas = new MenuTablasPanel(this);

		pantallaTablaMedicos = new PantallaTablaMedicos(this);
		
		pantallaTablaPacientes = new PantallaTablaPacientes(this);
		
		pantallaTablaTurnos = new PantallaTablaTurnos(this);
		
		panelAgergarMedico = new AgregarMedicoPanel(this);
		
		panelAgregarPaciente = new AgregarPacientePanel(this);
		
		panelAgregarTurno = new AgregarTurnoPanel(this);
		
		panelRegistrarUsuario = new RegistrarUsuarioPanel(this);
		
		panelEditarMedico = new EditarMedicoPanel(this);
		
		panelEditarPaciente = new EditarPacientePanel(this);
		
		panelEditarTurno = new EditarTurnoPanel(this);
		
		panelConsultaTurnos = new ConsultaTurnosPanel(this);
		
		panelSeleccionFechas = new SeleccionFechasPanel(this);
		
	
	}
	
	public void mostrarFrame() {
		frame.setVisible(true);
	}
	
	public void validarCampoNoNulo(String texto, String campo) throws CampoNuloException{
		if(texto.isEmpty()) {
			throw new CampoNuloException("El campo " + campo + " no puede estar vacío.");
		}
	}
	
	public int validarDNI(String dni) throws EnteroNoValidoException, LongitudException{
		
		int DNI = validarEntero(dni, "DNI");
		if(dni.length() != 8) {
			throw new LongitudException("El DNI debe tener 8 dígitos");
		}
		return DNI;
	}
	
	public int validarEntero(String numero, String nombre) throws EnteroNoValidoException{
		
		try {
			return Integer.parseInt(numero);
		}catch(NumberFormatException e) {
			throw new EnteroNoValidoException("El "+ nombre +" ingresado no es un número válido.");
		}
	}
	
	public void validarFormato(String fecha, String formato) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		sdf.parse(fecha);
		
	}
	
	public void validarHorario(String fecha, Medico medico) throws HorarioException{
	
		List<Turno> turnos = pantallaTablaTurnos.getTablaTurnosPanel().getModelo().getTurnos();
		
		for(Turno turno : turnos) {
			if(fecha.equals(turno.getFecha()) && medico.getDNI() == turno.getMedico().getDNI()) {
				throw new HorarioException("Este médico ya tiene un turno en el mismo horario");
			}
		}
	}
	
	public List<Usuario> crearListaUsuarios() {
		
		MedicoService service = new MedicoService(); 
		try {
			List<Medico> medicos = service.enlistarMedico();
			listaUsuarios = new ArrayList<>();
		
			for(Medico m : medicos) {
				listaUsuarios.add(m);
			}
			
			//return listaUsuarios;
			
		}catch(EnlistarException e) {
			System.out.println(e.getMessage());
		}
		return listaUsuarios;
	
	}
	
	public List<Medico> enlistarMedicosUI(){
		
		MedicoService service = new MedicoService();
		ModeloTablaMedicos modelo = pantallaTablaMedicos.getTablaMedicosPanel().getModelo();
		
		try {
			listaMedicos = service.enlistarMedico();
			modelo.setMedicos(listaMedicos); 
			modelo.fireTableDataChanged();
		}catch(EnlistarException e) {
			JOptionPane.showMessageDialog(pantallaTablaMedicos, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return listaMedicos;
	}
	
	
	public void mostrarPanelLogIn() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelLogIn);
		frame.setTitle("Incio de sesión");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
		}
	
	public void mostrarPanelHome() {
		panelHome.getLabelBienvenida().setText("Bienvenido "+panelLogIn.getUser().getNombre()+"!!"); 
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelHome);
		frame.setTitle("Home");
		//frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		frame.setSize(originalSize);
		}
	
	public void mostrarPanelMenuTablas() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelMenuTablas);
		frame.setTitle("Menú de tablas");
		//frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		frame.setSize(originalSize);
		}
	
	public void mostrarPanelConsultaTurnos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelConsultaTurnos);
		frame.setTitle("Consultar turnos por fecha");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelSeleccionFechas() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelSeleccionFechas);
		frame.setTitle("Selección fechas");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelReporte(int cont, int recaudacion) {
		panelReporte = new ReportePanel(this);
		panelReporte.setCont(cont);
		panelReporte.setRecaudacion(recaudacion);
		panelReporte.armarReporte();
		
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelReporte);
		frame.setTitle("Reporte de recaudación");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelListaTurnosPorFecha() {
		panelListaTurnosPorFecha = new ListaTurnosPorFechaPanel(this);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelListaTurnosPorFecha);
		frame.setTitle("Lista de turnos por fecha");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	
	public void mostrarPantallaTablaMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaTablaMedicos);
		frame.setTitle("Tabla médicos");
		//frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		frame.setSize(originalSize);
	}
	
	public void mostrarPantallaTablaPacientes() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaTablaPacientes);
		frame.setTitle("Tabla pacientes");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarPantallaTablaTurnos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaTablaTurnos);
		frame.setTitle("Tabla turnos");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	
	public void mostrarPanelAgregarMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelAgergarMedico);
		frame.setTitle("Agregar médico");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarPanelAgregarPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelAgregarPaciente);
		frame.setTitle("Agregar paciente");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarPanelAgregarTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelAgregarTurno);
		frame.setTitle("Agregar turno");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarPanelListaMedicos(String fecha) {
		panelListaMedicos = new ListaMedicosPanel(this);
		panelListaMedicos.setFecha(fecha);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelListaMedicos);
		frame.setTitle("Lista médicos");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelListaPacientes(String fecha, Medico medico) {
		
		panelListaPacientes = new ListaPacientesPanel(this);
		panelListaPacientes.setFecha(fecha);
		panelListaPacientes.setMedico(medico);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelListaPacientes);
		frame.setTitle("Lista pacientes");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelRegistrarUsuario() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelRegistrarUsuario);
		frame.setTitle("Registrarse");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		}
	
	public void mostrarPanelEditarMedico(Medico medico) {
		panelEditarMedico.getCamposMedicoPanel().getTextoNombre().setText(medico.getNombre());
		panelEditarMedico.getCamposMedicoPanel().getTextoApellido().setText(medico.getApellido());
		panelEditarMedico.getCamposMedicoPanel().getTextoDNI().setText(Integer.toString(medico.getDNI()));
		panelEditarMedico.getCamposMedicoPanel().getTextoCobro().setText(Integer.toString(medico.getCobro()));
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEditarMedico);
		frame.setTitle("Editar médico");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelEditarPaciente(Paciente paciente) {
		panelEditarPaciente.getCamposPacientePanel().getTextoNombre().setText(paciente.getNombre());
		panelEditarPaciente.getCamposPacientePanel().getTextoApellido().setText(paciente.getApellido());
		panelEditarPaciente.getCamposPacientePanel().getTextoDNI().setText(Integer.toString(paciente.getDNI()));
		panelEditarPaciente.getCamposPacientePanel().getTextoObraSocial().setText(Integer.toString(paciente.getNumeroObraSocial()));
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEditarPaciente);
		frame.setTitle("Editar paciente");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelEditarTurno(Turno turno) {
		panelEditarTurno.getCamposTurnoPanel().getTextoFecha().setText(turno.getFecha());
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelEditarTurno);
		frame.setTitle("Editar turno");
		frame.pack();
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	

	public AgregarMedicoPanel getPanelAgergarMedico() {
		return panelAgergarMedico;
	}

	public void setPanelAgergarMedico(AgregarMedicoPanel panelAgergarMedico) {
		this.panelAgergarMedico = panelAgergarMedico;
	}

	public LogInPanel getPanelLogIn() {
		return panelLogIn;
	}

	public void setPanelLogIn(LogInPanel panelInicio) {
		this.panelLogIn = panelInicio;
	}
	
	
	public HomePanel getPanelHome() {
		return panelHome;
	}

	public void setPanelHome(HomePanel panelHome) {
		this.panelHome = panelHome;
	}
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public RegistrarUsuarioPanel getPanelRegistrarUsuario() {
		return panelRegistrarUsuario;
	}

	public void setPanelRegistrarUsuario(RegistrarUsuarioPanel panelRegistrarUsuario) {
		this.panelRegistrarUsuario = panelRegistrarUsuario;
	}

	public EditarMedicoPanel getPanelEditarMedico() {
		return panelEditarMedico;
	}

	public void setPanelEditarMedico(EditarMedicoPanel panelEditarMedico) {
		this.panelEditarMedico = panelEditarMedico;
	}
	

	public AgregarPacientePanel getPanelAgregarPaciente() {
		return panelAgregarPaciente;
	}

	public void setPanelAgregarPaciente(AgregarPacientePanel panelAgregarPaciente) {
		this.panelAgregarPaciente = panelAgregarPaciente;
	}

	public EditarPacientePanel getPanelEditarPaciente() {
		return panelEditarPaciente;
	}

	public void setPanelEditarPaciente(EditarPacientePanel panelEditarPaciente) {
		this.panelEditarPaciente = panelEditarPaciente;
	}

	public BotoneraPanel getPanelBotonera() {
		return panelBotonera;
	}

	public void setPanelBotonera(BotoneraPanel panelBotonera) {
		this.panelBotonera = panelBotonera;
	}

	public CamposFormularioMedicoPanel getPanelCamposMedico() {
		return panelCamposMedico;
	}

	public void setPanelCamposMedico(CamposFormularioMedicoPanel panelCamposMedico) {
		this.panelCamposMedico = panelCamposMedico;
	}
	

	public CamposFormularioPacientePanel getPanelCamposPaciente() {
		return panelCamposPaciente;
	}

	public void setPanelCamposPaciente(CamposFormularioPacientePanel panelCamposPaciente) {
		this.panelCamposPaciente = panelCamposPaciente;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public PantallaTablaMedicos getPantallaTablaMedicos() {
		return pantallaTablaMedicos;
	}

	public void setPantallaTablaMedicos(PantallaTablaMedicos pantallaTablaMedicos) {
		this.pantallaTablaMedicos = pantallaTablaMedicos;
	}

	public PantallaTablaPacientes getPantallaTablaPacientes() {
		return pantallaTablaPacientes;
	}

	public void setPantallaTablaPacientes(PantallaTablaPacientes pantallaTablaPacientes) {
		this.pantallaTablaPacientes = pantallaTablaPacientes;
	}

	public CampoFechaTurnoPanel getPanelCamposTurnos() {
		return panelCamposTurnos;
	}

	public void setPanelCamposTurnos(CampoFechaTurnoPanel panelCamposTurnos) {
		this.panelCamposTurnos = panelCamposTurnos;
	}

	public AgregarTurnoPanel getPanelAgregarTurno() {
		return panelAgregarTurno;
	}

	public void setPanelAgregarTurno(AgregarTurnoPanel panelAgregarTurno) {
		this.panelAgregarTurno = panelAgregarTurno;
	}

	public PantallaTablaTurnos getPantallaTablaTurnos() {
		return pantallaTablaTurnos;
	}

	public void setPantallaTablaTurnos(PantallaTablaTurnos pantallaTablaTurnos) {
		this.pantallaTablaTurnos = pantallaTablaTurnos;
	}

	public EditarTurnoPanel getPanelEditarTurno() {
		return panelEditarTurno;
	}

	public void setPanelEditarTurno(EditarTurnoPanel panelEditarTurno) {
		this.panelEditarTurno = panelEditarTurno;
	}

	public ListaMedicosPanel getPanelListaMedicos() {
		return panelListaMedicos;
	}

	public void setPanelListaMedicos(ListaMedicosPanel panelListaMedicos) {
		this.panelListaMedicos = panelListaMedicos;
	}

	public ListaPacientesPanel getPanelListaPacientes() {
		return panelListaPacientes;
	}

	public void setPanelListaPacientes(ListaPacientesPanel panelListaPacientes) {
		this.panelListaPacientes = panelListaPacientes;
	}

	public ListaTurnosPorFechaPanel getPanelListaTurnosPorFecha() {
		return panelListaTurnosPorFecha;
	}

	public void setPanelListaTurnosPorFecha(ListaTurnosPorFechaPanel panelListaTurnosPorFecha) {
		this.panelListaTurnosPorFecha = panelListaTurnosPorFecha;
	}

	public MenuTablasPanel getPanelMenuTablas() {
		return panelMenuTablas;
	}

	public void setPanelMenuTablas(MenuTablasPanel panelMenuTablas) {
		this.panelMenuTablas = panelMenuTablas;
	}

	public ConsultaTurnosPanel getPanelConsultaTurnos() {
		return panelConsultaTurnos;
	}

	public void setPanelConsultaTurnos(ConsultaTurnosPanel panelConsultaTurnos) {
		this.panelConsultaTurnos = panelConsultaTurnos;
	}

	public SeleccionFechasPanel getPanelSeleccionFechas() {
		return panelSeleccionFechas;
	}

	public void setPanelSeleccionFechas(SeleccionFechasPanel panelSeleccionFechas) {
		this.panelSeleccionFechas = panelSeleccionFechas;
	}

	public ReportePanel getPanelReporte() {
		return panelReporte;
	}

	public void setPanelReporte(ReportePanel panelReporte) {
		this.panelReporte = panelReporte;
	}
	
	
}
