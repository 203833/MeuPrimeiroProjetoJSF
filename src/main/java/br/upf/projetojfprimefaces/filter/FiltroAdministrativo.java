package br.upf.projetojfprimefaces.filter;

import br.upf.projetojfprimefaces.entity.PessoaEntity;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/admin/*")
public class FiltroAdministrativo implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        PessoaEntity pessoaLogada = (PessoaEntity) session.getAttribute("pessoaLogada");

        if (pessoaLogada == null) {
            ((HttpServletResponse) response).sendRedirect("../login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }
}
