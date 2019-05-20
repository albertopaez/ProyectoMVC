package controlador;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
//se importa modeloDepartamento e interfaz
import modelo.ModeloDepartamento;
import modelo.ModeloProfesor;
import modelo.ModeloCurso;
import modelo.ModeloAlumno;
import vista.Interfaz;
/**
 * @author Alberto
 */

public class Controlador implements ActionListener, MouseListener, ItemListener{
	
	 

    /* instancia a nuestra interfaz de usuario*/
    Interfaz vista ;
    /** instancia a nuestro modeloDepartamento */
    ModeloDepartamento modeloDepartamento = new ModeloDepartamento();
    ModeloProfesor modeloProfesor = new ModeloProfesor();
    ModeloCurso modeloCurso = new ModeloCurso();
    ModeloAlumno modeloAlumno = new ModeloAlumno();

    /** Se declaran en un ENUM las acciones que se realizan desde la
 interfaz de usuario VISTA y posterior ejecución desde el Controlador
     */
    public enum AccionMVC
    {
        __AGREGAR_DEPARTAMENTOS,
        __ELIMINAR_DEPARTAMENTOS,
        __DEPARTAMENTOS_DESPLEGABLE,
        __AGREGAR_PROFESOR,
        __ELIMINAR_PROFESOR,
        __MOSTRAR_PROFESORES,
        __BUSCAR_PROFESOR,
        __MOSTRAR_CURSOS,
        __AGREGAR_CURSO,
        __ELIMINAR_CURSO,
        __MOSTRAR_ALUMNOS,
        __BUSCAR_ALUMNO,
        __AGREGAR_ALUMNO,
        __ELIMINAR_ALUMNO,
        __MATRICULAR_EN_CURSO,
        __DESMATRICULAR_DE_CURSO
        
    }

    /** Constrcutor de clase
     * @param vista Instancia de clase interfaz
     */
    public Controlador( Interfaz vista )
    {
        this.vista = vista;
    }

    /** Inicia el skin y las diferentes variables que se utilizan */
    public void iniciar()
    {
        // Skin tipo WINDOWS
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}

        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__AGREGAR_DEPARTAMENTOS.setActionCommand( "__AGREGAR_DEPARTAMENTOS" );
        this.vista.__AGREGAR_DEPARTAMENTOS.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__ELIMINAR_DEPARTAMENTOS.setActionCommand( "__ELIMINAR_DEPARTAMENTOS" );
        this.vista.__ELIMINAR_DEPARTAMENTOS.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__AGREGAR_PROFESOR.setActionCommand( "__AGREGAR_PROFESOR" );
        this.vista.__AGREGAR_PROFESOR.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__ELIMINAR_PROFESOR.setActionCommand( "__ELIMINAR_PROFESOR" );
        this.vista.__ELIMINAR_PROFESOR.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__MOSTRAR_PROFESORES.setActionCommand( "__MOSTRAR_PROFESORES" );
        this.vista.__MOSTRAR_PROFESORES.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__BUSCAR_PROFESOR.setActionCommand( "__BUSCAR_PROFESOR" );
        this.vista.__BUSCAR_PROFESOR.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__MOSTRAR_CURSOS.setActionCommand( "__MOSTRAR_CURSOS" );
        this.vista.__MOSTRAR_CURSOS.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__AGREGAR_CURSO.setActionCommand( "__AGREGAR_CURSO" );
        this.vista.__AGREGAR_CURSO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__ELIMINAR_CURSO.setActionCommand( "__ELIMINAR_CURSO" );
        this.vista.__ELIMINAR_CURSO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__MOSTRAR_ALUMNOS.setActionCommand( "__MOSTRAR_ALUMNOS" );
        this.vista.__MOSTRAR_ALUMNOS.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__BUSCAR_ALUMNO.setActionCommand( "__BUSCAR_ALUMNO" );
        this.vista.__BUSCAR_ALUMNO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__AGREGAR_ALUMNO.setActionCommand( "__AGREGAR_ALUMNO" );
        this.vista.__AGREGAR_ALUMNO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__ELIMINAR_ALUMNO.setActionCommand( "__ELIMINAR_ALUMNO" );
        this.vista.__ELIMINAR_ALUMNO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__MATRICULAR_EN_CURSO.setActionCommand( "__MATRICULAR_EN_CURSO" );
        this.vista.__MATRICULAR_EN_CURSO.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.vista.__DESMATRICULAR_DE_CURSO.setActionCommand( "__DESMATRICULAR_DE_CURSO" );
        this.vista.__DESMATRICULAR_DE_CURSO.addActionListener(this);
        
        
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.vista.__tabla_departamentosCursos.addMouseListener(this);
        this.vista.__tabla_departamentosCursos.setModel( new DefaultTableModel() );
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.vista.__tabla_departamentosProfesores.addMouseListener(this);
        this.vista.__tabla_departamentosProfesores.setModel( new DefaultTableModel() );
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.vista.__tabla_profesores.addMouseListener(this);
        this.vista.__tabla_profesores.setModel( new DefaultTableModel() );
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.vista.__tabla_cursos.addMouseListener(this);
        this.vista.__tabla_cursos.setModel( new DefaultTableModel() );
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.vista.__tabla_alumnos.addMouseListener(this);
        this.vista.__tabla_alumnos.setModel( new DefaultTableModel() );
        
        
        
        
        
        //añade e inicia el comboBox de Departamento con una lista de los departamentos
        this.vista.__DEPARTAMENTOS_DESPLEGABLE.addMouseListener(this);
        this.vista.__DEPARTAMENTOS_DESPLEGABLE.addItemListener(this);
        this.vista.__DEPARTAMENTOS_DESPLEGABLE.setModel( new DefaultComboBoxModel() );
        this.vista.__DEPARTAMENTOS_DESPLEGABLE.setModel(this.modeloDepartamento.getListaDepartamento() );
        //añade e inicia un comboBox de Profesor con una lista de los departamentos
        this.vista.__profesoresDepartamento.addItemListener(this);
        this.vista.__profesoresDepartamento.setModel( new DefaultComboBoxModel() );
        this.vista.__profesoresDepartamento.setModel(this.modeloDepartamento.getListaDepartamento() );
        //añade e inicia un comboBox de Profesor con los tipos de profesores
        this.vista.__profesoresTipo.addItemListener(this);
        this.vista.__profesoresTipo.setModel( new DefaultComboBoxModel() );
        this.vista.__profesoresTipo.addItem("Titular");
        this.vista.__profesoresTipo.addItem("Asociado");
        //añade e inicia un comboBox de Curso con una lista de las id de profesores
        this.vista.__cursosProfesor.addItemListener(this);
        this.vista.__cursosProfesor.setModel( new DefaultComboBoxModel() );
        this.vista.__cursosProfesor.setModel(this.modeloProfesor.getListaProfesor() );
        //añade e inicia un comboBox de Profesor con los tipos de cursos
        this.vista.__cursosTipo.addItemListener(this);
        this.vista.__cursosTipo.setModel( new DefaultComboBoxModel() );
        this.vista.__cursosTipo.addItem("Completo");
        this.vista.__cursosTipo.addItem("De Verano");
        //añade e inicia un comboBox de Alumnos con una lista de los cursos
        this.vista.__alumnosCurso.addItemListener(this);
        this.vista.__alumnosCurso.setModel( new DefaultComboBoxModel() );
        this.vista.__alumnosCurso.setModel(this.modeloCurso.getListaCurso() );
        
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        this.vista.__tabla_departamentosProfesores.setModel
        (this.modeloDepartamento.getTablaDepartamentoProfesores
        (this.vista.__DEPARTAMENTOS_DESPLEGABLE.getSelectedItem().toString()) );
        
        this.vista.__tabla_departamentosCursos.setModel
        (this.modeloDepartamento.getTablaDepartamentoCursos
        (this.vista.__DEPARTAMENTOS_DESPLEGABLE.getSelectedItem().toString()) );
    }
    
   

    //Eventos que suceden por el mouse
    
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int filap = this.vista.__tabla_profesores.rowAtPoint(e.getPoint());
             if (filap > -1){                
                this.vista.__profesoresBuscador.setText( String.valueOf( this.vista.__tabla_profesores.getValueAt(filap, 1) ));
             }
             int filac = this.vista.__tabla_cursos.rowAtPoint(e.getPoint());
             if (filac > -1){                
                this.vista.__cursosidCurso.setText( String.valueOf( this.vista.__tabla_cursos.getValueAt(filac, 0) ));
             }
             int filaa = this.vista.__tabla_alumnos.rowAtPoint(e.getPoint());
             if (filaa > -1){                
                this.vista.__alumnosBuscador.setText( String.valueOf( this.vista.__tabla_alumnos.getValueAt(filaa, 1) ));
             }
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) { }
 
    //Control de eventos de los controles que tienen definido un "ActionCommand"
    public void actionPerformed(ActionEvent e) {

    switch ( AccionMVC.valueOf( e.getActionCommand() ) )
        {
        
        case __AGREGAR_DEPARTAMENTOS:
                //añade un nuevo departamento
                if ( this.modeloDepartamento.NuevoDepartamento(this.vista.__departamento.getText()) )
                {
                    this.vista.__DEPARTAMENTOS_DESPLEGABLE.setModel(this.modeloDepartamento.getListaDepartamento() );
                    JOptionPane.showMessageDialog(vista,"Exito: Nuevo departamento agregado.");
                    this.vista.__departamento.setText("") ;
                }
                else //ocurrio un error
                    JOptionPane.showMessageDialog(vista,"Error: Los datos son incorrectos.");
                break;
	case __ELIMINAR_DEPARTAMENTOS:
            if ( this.modeloDepartamento.EliminarDepartamento( this.vista.__departamento.getText() ) )
                {
                    this.vista.__DEPARTAMENTOS_DESPLEGABLE.setModel(this.modeloDepartamento.getListaDepartamento() );
                    JOptionPane.showMessageDialog(vista,"Exito: Departamento eliminado.");
                    this.vista.__departamento.setText("");
                }else{
                JOptionPane.showMessageDialog(vista,"Fallo: No puede eliminar departamentos con profesores asociados.");
            }
		break;
                
                
                
                case __MOSTRAR_PROFESORES:
            //obtiene del modeloProfesor los registros en un DefaultTableModel y lo asigna en la vista
                this.vista.__tabla_profesores.setModel(this.modeloProfesor.getTablaProfesoresGeneral() );
            break;
            case __BUSCAR_PROFESOR:
            //obtiene del modeloProfesor los registros en un DefaultTableModel y lo asigna en la vista
                this.vista.__tabla_profesores.setModel(this.modeloProfesor.getTablaProfesorPersonal(this.vista.__profesoresBuscador.getText()) );
            break;
            case __ELIMINAR_PROFESOR:
            if ( this.modeloProfesor.EliminarProfesor( this.vista.__profesoresBuscador.getText() ) )
                {
                    this.vista.__tabla_profesores.setModel(this.modeloProfesor.getTablaProfesoresGeneral() );
                    JOptionPane.showMessageDialog(vista,"Exito: Profesor eliminado.");
                    this.vista.__profesoresBuscador.setText("");
                }else{
                JOptionPane.showMessageDialog(vista,"Fallo: No puede eliminar profesores con cursos asociados.");
            }
		break;
            case __AGREGAR_PROFESOR:
                //añade un nuevo registro
                
                if ( this.modeloProfesor.nuevoProfesor(
                        this.vista.__profesoresNombre.getText(),
                        this.vista.__profesoresDepartamento.getSelectedItem().toString() ,
                        this.vista.__profesoresTipo.getSelectedItem().toString(),
                        this.vista.__profesoresTutorias.getText() ,
                        this.vista.__profesoresHorasInvestigacion.getText(),
                        this.vista.__profesoresSueldo.getText() ,
                        this.vista.__profesoresidProfesor.getText(),
                        this.vista.__profesoresUsuario.getText(),
                        this.vista.__profesoresPassword.getText() ) )
                {
                    this.vista.__tabla_profesores.setModel( this.modeloProfesor.getTablaProfesoresGeneral() );
                    JOptionPane.showMessageDialog(vista,"Exito: Nuevo registro agregado.");
                    this.vista.__profesoresNombre.setText("");
                        this.vista.__profesoresTutorias.setText("") ;
                        this.vista.__profesoresHorasInvestigacion.setText("");
                        this.vista.__profesoresSueldo.setText("") ;
                        this.vista.__profesoresidProfesor.setText("");
                        this.vista.__profesoresUsuario.setText("");
                        this.vista.__profesoresPassword.setText("");
                }else //ocurrio un error
                    JOptionPane.showMessageDialog(vista,"Error: Los datos son incorrectos.");
                break;
                
                
                
                 case __MOSTRAR_CURSOS:
            //obtiene del modeloCurso los registros en un DefaultTableModel y lo asigna en la vista
                this.vista.__tabla_cursos.setModel(this.modeloCurso.getTablaCursos() );
            break;
            case __ELIMINAR_CURSO:
            if ( this.modeloCurso.EliminarCurso( this.vista.__cursosidCurso.getText() ) )
                {
                    this.vista.__tabla_cursos.setModel(this.modeloCurso.getTablaCursos() );
                    JOptionPane.showMessageDialog(vista,"Exito: Curso eliminado.");
                    this.vista.__profesoresBuscador.setText("");
                }else{
                JOptionPane.showMessageDialog(vista,"Fallo: No puede eliminar cursos con alumnos asociados.");
            }
		break;
            case __AGREGAR_CURSO:
                //añade un nuevo registro
                if ( this.modeloCurso.nuevoCurso(
                        this.vista.__cursosidCurso.getText(),
                        this.vista.__cursosTipo.getSelectedItem().toString() ,
                        this.vista.__cursosProfesor.getSelectedItem().toString(),
                        this.vista.__cursosCreditos.getText(),
                        this.vista.__cursosHoras.getText() ,
                        this.vista.__cursosPrecio.getText()) )
                {
                    this.vista.__tabla_cursos.setModel( this.modeloCurso.getTablaCursos() );
                    JOptionPane.showMessageDialog(vista,"Exito: Nuevo registro agregado.");
                        this.vista.__cursosidCurso.setText("");
                        this.vista.__cursosCreditos.setText("");
                        this.vista.__cursosHoras.setText("") ;
                        this.vista.__cursosPrecio.setText("");
                }else //ocurrio un error
                    JOptionPane.showMessageDialog(vista,"Error: Los datos son incorrectos.");
                break;
                
                
                
                
                case __MOSTRAR_ALUMNOS:
            //obtiene del modeloProfesor los registros en un DefaultTableModel y lo asigna en la vista
                this.vista.__tabla_alumnos.setModel(this.modeloAlumno.getAlumnosGeneral() );
            break;
                case __ELIMINAR_ALUMNO:
            if ( this.modeloAlumno.EliminarAlumno( this.vista.__alumnosBuscador.getText() ) )
                {
                    this.vista.__tabla_alumnos.setModel(this.modeloAlumno.getAlumnosGeneral() );
                    JOptionPane.showMessageDialog(vista,"Exito: Alumno eliminado.");
                    this.vista.__alumnosBuscador.setText("");
                }else{
                JOptionPane.showMessageDialog(vista,"Fallo: Los datos son incorrectos.");
            }
		break;
                
                
                
                
	default:
		break;
         
        }
    }

	

}
