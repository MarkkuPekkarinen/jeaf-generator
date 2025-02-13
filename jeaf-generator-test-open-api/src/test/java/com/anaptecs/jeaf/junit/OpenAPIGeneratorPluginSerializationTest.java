/**
 * Copyright 2004 - 2021 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.anaptecs.jeaf.json.api.JSON;
import com.anaptecs.jeaf.json.api.JSONTools;
import com.fasterxml.jackson.core.JsonProcessingException;

import openapitools.model.CHStopPlace;
import openapitools.model.GeoPosition;
import openapitools.model.Leg;
import openapitools.model.PlaceRef;
import openapitools.model.SwissGeoPosition;
import openapitools.model.TopoRef;
import openapitools.model.UICStopPlace;

@Disabled
public class OpenAPIGeneratorPluginSerializationTest {
  @Test
  void testPolymorphAssociations( ) throws JsonProcessingException {
    JSONTools lTools = JSON.getJSONTools();

    UICStopPlace lBern = new UICStopPlace();
    lBern.setName("Bern");
    lBern.setObjectType("UICStopPlace");

    String lJSON = lTools.writeObjectToString(lBern);
    assertEquals("{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"}", lJSON);

    lJSON = lTools.writeObjectToString(lBern);
    assertEquals("{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"}", lJSON);
    PlaceRef lReadPlaceRef = lTools.read(lJSON, UICStopPlace.class);
    assertEquals(UICStopPlace.class, lReadPlaceRef.getClass());
    UICStopPlace lUICStopPlace = (UICStopPlace) lReadPlaceRef;
    assertEquals("Bern", lUICStopPlace.getName());

    CHStopPlace lZurich = new CHStopPlace();
    lZurich.setName("Zürich");
    lZurich.setObjectType("CHStopPlace");

    lJSON = lTools.writeObjectToString(lZurich);
    assertEquals("{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"}", lJSON);
    lReadPlaceRef = lTools.read(lJSON, PlaceRef.class);
    assertEquals(CHStopPlace.class, lReadPlaceRef.getClass());
    CHStopPlace lCHStopPlace = (CHStopPlace) lReadPlaceRef;
    assertEquals("Zürich", lCHStopPlace.getName());

    SwissGeoPosition lUniBern = new SwissGeoPosition();
    lUniBern.setLongitude(0);
    lUniBern.setLatitude(0);
    lUniBern.setName("Uni Bern");
    lUniBern.setObjectType("SwissGeoPosition");

    TopoRef lOlten = new TopoRef();
    lOlten.setName("Olten");
    lOlten.setObjectType("TopoRef");

    GeoPosition lSomewhere = new GeoPosition();
    lSomewhere.setLongitude(47);
    lSomewhere.setLatitude(11);
    lSomewhere.setName("What do I know ;-)");
    lSomewhere.setObjectType("GeoPosition");

    List<PlaceRef> lStops = new ArrayList<>();
    lStops.add(lBern);
    lStops.add(lUniBern);
    lStops.add(lOlten);
    lStops.add(lZurich);

    lJSON = lTools.writeObjectsToString(lStops, PlaceRef.class);
    assertEquals(
        "[{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"},{\"objectType\":\"SwissGeoPosition\",\"name\":\"Uni Bern\",\"longitude\":0,\"latitude\":0},{\"objectType\":\"TopoRef\",\"name\":\"Olten\"},{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"}]",
        lJSON);

    Leg lLeg = new Leg();
    lLeg.setStart(lBern);
    lLeg.setStop(lZurich);

    lLeg.addStopoversItem(lUniBern);
    lLeg.addStopoversItem(lOlten);
    lLeg.addStopoversItem(lSomewhere);

    lJSON = lTools.writeObjectToString(lLeg);
    assertEquals(
        "{\"start\":{\"objectType\":\"UICStopPlace\",\"name\":\"Bern\"},\"stop\":{\"objectType\":\"CHStopPlace\",\"name\":\"Zürich\"},\"stopovers\":[{\"objectType\":\"SwissGeoPosition\",\"name\":\"Uni Bern\",\"longitude\":0,\"latitude\":0},{\"objectType\":\"TopoRef\",\"name\":\"Olten\"},{\"longitude\":47,\"latitude\":11,\"objectType\":\"GeoPosition\",\"name\":\"What do I know ;-)\"}]}",
        lJSON);

    Leg lDeserializedLeg = lTools.read(lJSON, Leg.class);
    assertEquals(UICStopPlace.class, lDeserializedLeg.getStart().getClass());
    assertEquals("Bern", lDeserializedLeg.getStart().getName());
    assertEquals(CHStopPlace.class, lDeserializedLeg.getStop().getClass());
    assertEquals("Zürich", lDeserializedLeg.getStop().getName());

    List<PlaceRef> lStopovers = lDeserializedLeg.getStopovers();
    assertEquals(SwissGeoPosition.class, lStopovers.get(0).getClass());
    assertEquals("Uni Bern", lStopovers.get(0).getName());
    assertEquals(TopoRef.class, lStopovers.get(1).getClass());
    assertEquals("Olten", lStopovers.get(1).getName());
    assertEquals(GeoPosition.class, lStopovers.get(2).getClass());
    assertEquals("What do I know ;-)", lStopovers.get(2).getName());
    assertEquals(3, lStopovers.size());
  }
}
