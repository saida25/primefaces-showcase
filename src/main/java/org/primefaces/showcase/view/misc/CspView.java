/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.view.misc;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import org.primefaces.context.PrimeApplicationContext;

@ManagedBean
@ViewScoped
public class CspView implements Serializable {
    
    private boolean cspEnabled;
    private String userSuppliedInput;
    
    public CspView() {
        cspEnabled = PrimeApplicationContext.getCurrentInstance(FacesContext.getCurrentInstance()).getConfig().isCsp();
        userSuppliedInput = "<b>Huhu</b><script>window.cspScriptExecuted=true;alert('XSS');</script>";
    }

    public void check() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Success",  "PASS"));
    }

    public String getUserSuppliedInput() {
        return userSuppliedInput;
    }

    public void setUserSuppliedInput(String userSuppliedInput) {
        this.userSuppliedInput = userSuppliedInput;
    }

    public boolean isCspEnabled() {
        return cspEnabled;
    }
}
