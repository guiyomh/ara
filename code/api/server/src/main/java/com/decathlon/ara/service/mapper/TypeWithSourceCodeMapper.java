/******************************************************************************
 * Copyright (C) 2019 by the ARA Contributors                                 *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License");            *
 * you may not use this file except in compliance with the License.           *
 * You may obtain a copy of the License at                                    *
 *                                                                            *
 * 	 http://www.apache.org/licenses/LICENSE-2.0                               *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 *                                                                            *
 ******************************************************************************/

package com.decathlon.ara.service.mapper;

import com.decathlon.ara.domain.Type;
import com.decathlon.ara.service.dto.type.TypeWithSourceCodeDTO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mapper for the entity Type and its DTO TypeWithSourceCodeDTO.
 */
@Mapper
public interface TypeWithSourceCodeMapper extends EntityMapper<TypeWithSourceCodeDTO, Type> {

    @Override
    @Mapping(source = "sourceCode", target = "source.code")
    Type toEntity(TypeWithSourceCodeDTO dto);

    @Override
    @Mapping(source = "source.code", target = "sourceCode")
    TypeWithSourceCodeDTO toDto(Type entity);

    @AfterMapping
    default void removeEmptySource(@MappingTarget Type entity) {
        if (StringUtils.isEmpty(entity.getSource().getCode())) {
            entity.setSource(null);
        }
    }

}
