<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:c="http://java.sun.com/jstl/core">

	<rich:panel id="Beacon">
		<h:outputText value="Test: injection de valeurs de BeaconView:#{BeaconView.testInt}"/>
		Position du robot: X: <h:outputText value="#{BeaconView.computedXRobotPosition}"/> Y: <h:outputText value="#{BeaconView.computedYRobotPosition}"/>
	</rich:panel>

</ui:composition>
