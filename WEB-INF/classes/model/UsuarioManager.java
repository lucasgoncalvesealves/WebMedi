package model;

public class UsuarioManager 
{
	public static String logarNoSistema( String usuario, String senha, String quemsou ) {

		if( usuario.isEmpty() )
		{
			return "Usu�rio N�o Informado!";
		}
		if( senha.isEmpty() )
		{
			return "Senha N�o Informada!";
		}
		if( quemsou.isEmpty() )
		{
			return "Quem Sou N�o Informado!";
		}

		String msg = "";
		if( usuario.equals( "Marcelo" ) || usuario.equals( "Tales" ) || usuario.equals( "Lucas" ) || usuario.equals( "Hernani" ) ) {
			if (!senha.equals("123456")) {
				msg = "Senha N�o Confere!";
			}
		}
		else {
			msg = "Usu�rio N�o Cadastrado!";
		}
		return msg;
	}

}
