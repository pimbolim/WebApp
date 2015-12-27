package org.nuno.utils;

public class ResponseMessage {
	private long id;
	private String tipo;
	
	
	public ResponseMessage() {
		
	}

	public ResponseMessage setUserInsertFail(String email){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(1);
		rsp.setTipo("Erro - User with email: " + email + " already on database.");
		return rsp;
	}
	
	public ResponseMessage setUserInsertOK(String email){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("OK - User Inserted with email: " + email );
		return rsp;
	}

	public ResponseMessage setUserDeleteFail(String email){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(1);
		rsp.setTipo("Erro - User with email: " + email + " don`t exists.");
		return rsp;
	}
	
	public ResponseMessage setUserDeleteOK(String email){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("OK - User Deleted with email: " + email );
		return rsp;
	}
	
	public ResponseMessage setInsertOK(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("OK - "+type+" Inserted ");
		return rsp;
	}
	public ResponseMessage setInsertFail(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("ERROR - "+type+" Insert Failed ");
		return rsp;
	}
	public ResponseMessage setDeleteOK(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("Ok - "+type+" Deleted");
		return rsp;
	}
	public ResponseMessage setDeleteFail(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("ERROR - "+type+" Insert Failed ");
		return rsp;
	}
	public ResponseMessage setUploadOK(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("Ok - "+type+" Uploaded");
		return rsp;
	}
	public ResponseMessage setUploadFail(String type){
		ResponseMessage rsp = new ResponseMessage();
		rsp.setId(2);
		rsp.setTipo("ERROR - "+type+" Upload Failed ");
		return rsp;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
