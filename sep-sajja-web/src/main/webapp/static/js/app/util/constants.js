define([], function(){
	return{
		CHARACTERS_VALID: "((^[0-9A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]?)|(^[0-9A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]+))([0-9A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]$)",
		NOMBRE_VALID: "((^[A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]?)|(^[A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]+))([A-Za-z\\s\u00f1\u00d1.,\\-_\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00e4\u00eb\u00ef\u00f6\u00fc\u00c4\u00cb\u00cf\u00d6\u00dc]$)",
		CURP_VALID: "^[a-zA-Z]{4}\\d{6}[a-zA-Z]{6}\\d{2}$",
		INTEXT_VALID: "((^[0-9A-Za-z\\s\\-]?)|(^[0-9A-Za-z\\s\\-]+))([0-9A-Za-z\\s\\-]$)",
		TELEPHONE_VALID: "(^[0-9A-Za-z\\s.,\-]+)([0-9A-Za-z\\s.,\-]$)",
		LADA_VALID: "[0-9]+",
		NUMBER_VALID: "[0-9]+",
		CEDULA_VALID: "[0-9]{7}",
		MAIL_VALID: "(^[0-9a-zA-Z]+(?:[._\\-0-9a-zA-Z]+)*)@([0-9a-zA-Z]+(?:[._-][0-9a-zA-Z]+)*\\.[0-9a-zA-Z]{2,3})$",
		CP_VALID: "\\d{5}",
		
		BIG_BIG_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:750px;",
		BIG_LONG_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:750px;",
		LONG_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:450px;",
		SHORT_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:95px;",
		MEDIUM_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:140px;",
		DEFAULT_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:210px;",
		CUSTOM_STYLE: "font-family: Arial, Verdana, Helvetica, sans-serif;font-size:0.9em;width:210px;",
		MASK_IMAGES: [
	                 			["Jpeg File", 	"*.jpg;*.jpeg"],
	                			["GIF File", 	"*.gif"],
	                			["PNG File", 	"*.png"],
	                			["All Images", 	"*.jpg;*.jpeg;*.gif;*.png"]
	                		],
		MASK_DOCUMENTOS: [
	                 			["Documento MsWord", "*.doc;*.docx"],
						["Hoja de c\u00E1lculo MsExcel", "*.xls;*.xlsx"],
						["PDF", "*.pdf"]
					],
		TYPE_FILES_FILTER: {
			//TYPE_FILE_MS_WORD: { type:"application/msword", descripcion: ".doc"},
			//TYPE_FILE_MS_XWORD: { type:"application/vnd.openxmlformats-officedocument.wordprocessingml.document", descripcion: ".docx"},
			//TYPE_FILE_MS_EXCEL: { type:"application/vnd.ms-excel", descripcion: ".xls"},
			//TYPE_FILE_MS_XEXCEL: { type:"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", descripcion: ".xlsx"},
			//TYPE_FILE_ZIP: { type:"application/zip", descripcion: ".zip"},
			TYPE_FILE_PDF: { type:"application/pdf", descripcion: ".pdf"}
		},
		EXT_FILES: new Array('txt','csv')
	};
});


