package org.serratec.java2backend.projetocrud.model;

public class Escola {

		
		private Integer Id;
		private String materia;
		private String professor;
		
		
		
		public Escola() {}



		public Escola(Integer id, String materia, String professor) {
			super();
			Id = id;
			this.materia = materia;
			this.professor = professor;
		}



		public Integer getId() {
			return Id;
		}



		public void setId(Integer id) {
			Id = id;
		}



		public String getMateria() {
			return materia;
		}



		public void setMateria(String materia) {
			this.materia = materia;
		}



		public String getProfessor() {
			return professor;
		}



		public void setProfessor(String professor) {
			this.professor = professor;
		}
		
		

}


