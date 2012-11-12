<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%; height: 100%;" id="tblCapturaReqJudicial">
	<tr height="99%">
		<td style="width: 1%">&nbsp;</td>
		<td style="width: 98%;" align="center" valign="top">
			<table width="100%">
				<tr>
					<td>
						<div id="divFormAsunto{aleatorio}"/>	
					</td>
				</tr>
				<tr>
					<td>
						<div id="divTabConteinerReqJudicial{aleatorio}">
							<div id="divTabInfoGral{aleatorio}">
								<div id="contentDivTabInfoGral{aleatorio}"></div>
							</div>
							<div id="divTabArchivo{aleatorio}">
								<div id="contentDivTabArchivo{aleatorio}"></div>
							</div>
							<div id="divTabOficios{aleatorio}">
								<div id="contentDivTabOficios{aleatorio}"></div>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<div id="divPruebaRender"></div>
		</td>
		<td style="width: 1%">&nbsp;</td>
	</tr>
	<tr height="1%">
		<td >&nbsp;</td>
		<td style="text-align: center; vertical-align: bottom" class="borderTop">
			<input id="btnAceptarReqJudicial{aleatorio}" />
			<input id="btnCancelarReqJudicial{aleatorio}" />
		</td>
		<td >&nbsp;</td>
	</tr>
</table>