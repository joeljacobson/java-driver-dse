/*
 *      Copyright (C) 2012-2015 DataStax Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.datastax.driver.dse.graph;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;

import java.util.Map;

/**
 * A default representation of an edge in DSE Graph.
 */
public class Edge extends Element {

    private GraphResult inV;

    private String inVLabel;

    private GraphResult outV;

    private String outVLabel;

    /**
     * Builds a new instance.
     *
     * @param id         the identifier.
     * @param label      the label.
     * @param type       the type.
     * @param properties the edge properties.
     * @param inV        the incoming/head vertex.
     * @param inVLabel   the label of the incoming/head vertex.
     * @param outV       the outgoing/tail vertex.
     * @param outVLabel  the label of the outgoing/tail vertex.
     */
    public Edge(GraphResult id, String label, String type, Map<String, GraphResult> properties, GraphResult inV, String inVLabel, GraphResult outV, String outVLabel) {
        super(id, label, type, properties);
        this.inV = inV;
        this.inVLabel = inVLabel;
        this.outV = outV;
        this.outVLabel = outVLabel;
    }

    /**
     * Returns the incoming/head vertex.
     *
     * @return the vertex.
     */
    public GraphResult getInV() {
        return inV;
    }

    /**
     * Sets the incoming/head vertex.
     *
     * @param inV the new value.
     */
    public void setInV(GraphResult inV) {
        this.inV = inV;
    }

    /**
     * Returns the label of the incoming/head vertex.
     *
     * @return the label.
     */
    public String getInVLabel() {
        return inVLabel;
    }

    /**
     * Sets the label of the incoming/head vertex.
     *
     * @param inVLabel the new value.
     */
    public void setInVLabel(String inVLabel) {
        this.inVLabel = inVLabel;
    }

    /**
     * Returns the outgoing/tail vertex.
     *
     * @return the vertex.
     */
    public GraphResult getOutV() {
        return outV;
    }

    /**
     * Sets the outgoing/tail vertex.
     *
     * @param outV the new value.
     */
    public void setOutV(GraphResult outV) {
        this.outV = outV;
    }

    /**
     * Returns the label of the outgoing/tail vertex.
     *
     * @return the label.
     */
    public String getOutVLabel() {
        return outVLabel;
    }

    /**
     * Sets the label of the outgoing/tail vertex.
     *
     * @param outVLabel the new value.
     */
    public void setOutVLabel(String outVLabel) {
        this.outVLabel = outVLabel;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other instanceof Edge) {
            Edge that = (Edge) other;
            return Objects.equal(this.id, that.id) &&
                    Objects.equal(this.label, that.label) &&
                    Objects.equal(this.type, that.type) &&
                    Objects.equal(this.properties, that.properties) &&
                    Objects.equal(this.inV, that.inV) &&
                    Objects.equal(this.inVLabel, that.inVLabel) &&
                    Objects.equal(this.outV, that.outV) &&
                    Objects.equal(this.outVLabel, that.outVLabel);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, label, type, properties, inV, inVLabel, outV, outVLabel);
    }

    @Override
    public String toString() {
        return "Graph Edge [" +
                String.format(
                        "id = %s, label = %s, inV = %s, inVLabel = %s, outV = %s, outVLabel = %s",
                        this.id, this.label, this.inV, this.inVLabel, this.outV, this.outVLabel) +
                ", properties = {" +
                (this.properties == null ? "" : Joiner.on(", ").withKeyValueSeparator(":").join(this.properties)) +
                "}]";
    }
}
