/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.*;

/**
 *
 * @author timot
 */
public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And();
    }
    
    public Matcher build() {
        Matcher toBeReturned = this.matcher;
        this.matcher = new And();
        return toBeReturned;
    }
    
    public QueryBuilder playsIn(String name) {
        this.matcher = new And(this.matcher, new PlaysIn(name));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int number, String field) {
        this.matcher = new And(this.matcher, new HasAtLeast(number, field));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int number, String field) {
        this.matcher = new And(this.matcher, new HasFewerThan(number, field));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matcher = new And(this.matcher, new Not(matcher));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    
    
}
