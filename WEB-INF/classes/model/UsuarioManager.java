package model;

public class UsuarioManager 
{
	public static String logarNoSistema( String usuario, String senha, String quemsou ) {

		if( usuario.isEmpty() )
		{
			return "Usuário Não Informado!";
		}
		if( senha.isEmpty() )
		{
			return "Senha Não Informada!";
		}
		if( quemsou.isEmpty() )
		{
			return "Quem Sou Não Informado!";
		}

		String msg = "";
		if( usuario.equals( "Marcelo" ) || usuario.equals( "Tales" ) || usuario.equals( "Lucas" ) || usuario.equals( "Hernani" ) ) {
			if (!senha.equals("123456")) {
				msg = "Senha Não Confere!";
			}
		}
		else {
			msg = "Usuário Não Cadastrado!";
		}
		return msg;
	}

}
