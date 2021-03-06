/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teiid.spring.example;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.teiid.spring.annotations.JsonTable;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee_skills")
@JsonTable(endpoint = "employee.json", source = "file", root = "/skills", rootIsArray=true)
public class Skills implements Serializable{

    @ManyToOne
    @Id
    @JoinColumn(name = "id", nullable = false, updatable = true)
    private Employee employee;

    private String type;

    private int rating;

    public Skills() {
    }

    public Skills(String type, int rating) {
        this.type = type;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "[type=" + type + ", rating=" + rating + "]";
    }
}
