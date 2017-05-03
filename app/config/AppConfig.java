package config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"controllers", "services.impl", "util.logging"})
public class AppConfig { }