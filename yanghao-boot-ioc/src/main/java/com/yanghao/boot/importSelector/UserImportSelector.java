package com.yanghao.boot.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yanghao
 * @create 2020-03-23 14:26
 * @Description:
 */
public class UserImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.yanghao.boot.importSelector.RoleBean","com.yanghao.boot.importSelector.UsersBean"};
    }
}
