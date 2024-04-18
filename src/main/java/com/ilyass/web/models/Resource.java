package com.ilyass.web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="resources")
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
    private String resourceName;
    private String description;
    private String type;
    private String link;
    private String accessibility;
    
}
