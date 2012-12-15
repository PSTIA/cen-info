<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	xmlns:c="http://java.sun.com/jstl/core">

	<rich:panel id="Beacon">
		<h:outputText value="Test: injection de valeurs de BeaconView:#{BeaconView.testInt}"></h:outputText>
		<h:inputText id="test" value="#{BeaconView.testInt}" >
			<a4j:support event="onchange" reRender="Beacon" />
		</h:inputText>
		<h:commandButton action="#{BeaconView.settestInt}" value="Send Text" />
		<h:form>
			<h:commandButton action="refresh" value="Refresh" />
		</h:form>
	</rich:panel>

</ui:composition>
