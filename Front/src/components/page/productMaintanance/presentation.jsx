import React from 'react';

const Presentation = () => {

    return (
        <div className="m-2">
            <section className="jumbotron text-center">
                <div className="container">
                    <h1>Manutenção de Produtos</h1>
                    <p className="lead text-muted">Aqui pode mudar preços, excluir produtos, ou editar suas características</p>
                    <p>
                        <a href="#" className="btn btn-dark my-2">Manutenção</a>
                        <a href="#" className="btn btn-secondary my-2">Vizualização</a>
                        <a href="#" className="btn btn-dark my-2">  Edição  </a>
                    </p>
                </div>
            </section>
        </div>
    )
}
export default Presentation;