package br.ufc.quixada.spa.control;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.h2.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.npi.enumeration.ResponseStatus;
import br.ufc.quixada.npi.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Documento;
import br.ufc.quixada.spa.service.DocumentoService;

@Controller
@RequestMapping("documentos")
public class DocumentoController {
	private Logger log = LoggerFactory.getLogger(this.getClass());	
	@Inject
	private DocumentoService serviceDocumento;

	// add arquivo
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Long handleFileUpload(@RequestParam("file") MultipartFile file){
		
		log.debug("Documento - POST");
        if (!file.isEmpty()) {
        	try {
				if (file.getBytes() != null
						&& file.getBytes().length != 0) {
					Documento documento = new Documento();
					documento.setArquivo(file.getBytes());
					documento.setNome(file.getOriginalFilename());
					documento.setNomeOriginal	(file.getOriginalFilename());
					documento.setTipo(file.getContentType());
					serviceDocumento.save(documento);
					//retornar o ID do documento
					return documento.getId();
				}
			} catch (IOException ioe) {
				return (long) -1;
			}
        }
        return (long) -1;
        
        
    }

	// listar arquivos
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Documento> findAll() {
		log.debug("Documento - GET (all)");
		return serviceDocumento.find(Documento.class);
	}
	
	// get by id
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Documento findById(@PathVariable Integer id) {
		log.debug("Documento - GET (id)");
		return serviceDocumento.find(Documento.class, (long) id);
	}
	
	// excluir
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Documento - DELETE");
		serviceDocumento.delete(new Documento(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Documento removida com sucesso");
	}
	
	// download arquivo
	@RequestMapping(value = "/{id}/download", method = RequestMethod.GET)
	public void getFile(@PathVariable("id") Long id, HttpServletResponse response) {
		try {
			Documento documento = serviceDocumento.find(Documento.class, id);
			if (documento != null) {

				InputStream is = new ByteArrayInputStream(documento.getArquivo());
				response.setContentType(documento.getTipo());
				response.setHeader("Content-Disposition",
						"attachment; filename=" + documento.getNomeOriginal().replace(" ", "_"));
				IOUtils.copy(is, response.getOutputStream());

				response.flushBuffer();
			}
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

}
