/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication16;

/**
 *
 * @author adithyamorampudi
 */
public class AuthorizationException extends RuntimeException {
public AuthorizationException(String methodName) {
	super("Invalid Authorization - Access Denined to " + methodName + "() function!");
}
}
