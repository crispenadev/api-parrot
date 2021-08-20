package mx.com.parrot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.parrot.entity.Report;
import mx.com.parrot.service.ReportService;



/**
 * Controler rest para la invocacion de servicios de obtencion de Reporte
 * 
 * @author Cristian Ivan Peña
 *
 */
@RestController
public class ReportController {

	private static final Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private ReportService reportService;


	
	@Operation(summary = "Get a report of products data by date range")
	@ApiResponse(responseCode = "200", description = "Success Response", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Report.class)) })
	@GetMapping("/api-parrot/report")
	public Report getReport(@RequestBody ReportRequest request) {
		log.info("Paylod in  getReport : "+ request);
		return reportService.getReport(request);
	}

}
