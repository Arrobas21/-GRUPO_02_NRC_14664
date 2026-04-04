package Clases;

public class Prestamo {

		private int idPrestamo;
		private Libro libro;           
		private Estudiante estudiante; 
		private String fechaSalida;
		private String fechaLimite;
		private String estado;
		
		public Prestamo(int idPrestamo, Libro libro, Estudiante estudiante, String fechaSalida, String fechaLimite, String estado) {
			
			this.idPrestamo = idPrestamo;
			this.libro = libro;
			this.estudiante = estudiante;
			this.fechaSalida = fechaSalida;
			this.fechaLimite = fechaLimite;
			this.estado = estado;
		}

		public int getIdPrestamo() {
			return idPrestamo;
		}

		public void setIdPrestamo(int idPrestamo) {
			this.idPrestamo = idPrestamo;
		}

		public Libro getLibro() {
			return libro;
		}

		public void setLibro(Libro libro) {
			this.libro = libro;
		}

		public Estudiante getEstudiante() {
			return estudiante;
		}

		public void setEstudiante(Estudiante estudiante) {
			this.estudiante = estudiante;
		}

		public String getFechaSalida() {
			return fechaSalida;
		}

		public void setFechaSalida(String fechaSalida) {
			this.fechaSalida = fechaSalida;
		}

		public String getFechaLimite() {
			return fechaLimite;
		}

		public void setFechaLimite(String fechaLimite) {
			this.fechaLimite = fechaLimite;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
		public void mostrarResumen() {
			System.out.println("Resumen de Préstamo #" + idPrestamo);
			System.out.println("Libro: " + libro.getTitulo());
			System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellidos());
			System.out.println("Fecha Límite: " + fechaLimite);
			System.out.println("Estado: " + estado);
	}
}


