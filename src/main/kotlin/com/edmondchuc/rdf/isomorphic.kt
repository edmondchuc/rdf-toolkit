package com.edmondchuc.rdf

import org.apache.jena.graph.Graph
import org.apache.jena.riot.Lang
import org.apache.jena.riot.RDFDataMgr
import org.apache.jena.sparql.graph.GraphFactory

fun getJenaFormat(format: String): Lang {
    return when (format) {
        "text/turtle" -> Lang.TTL
        "application/n-triples" -> Lang.NTRIPLES
        "application/rdf+xml" -> Lang.RDFXML
        "application/ld+json" -> Lang.JSONLD
        else -> throw IllegalArgumentException("Unknown format: $format")
    }
}

fun createGraph(data: String, format: String): Graph {
    val graph = GraphFactory.createDefaultGraph()
    RDFDataMgr.read(graph, data.byteInputStream(), getJenaFormat(format))
    return graph
}

fun isomorphic(graphOneData: String, graphOneFormat: String, graphTwoData: String, graphTwoFormat: String): Boolean {
    val graphOne = createGraph(graphOneData, graphOneFormat)
    val graphTwo = createGraph(graphTwoData, graphTwoFormat)
    return graphOne.isIsomorphicWith(graphTwo)
}