import Headers from "./nav"
import ProductForm from "./productMaintanance/form";

import {Component} from "react";

class Page extends Component {
    render() {
        return (
            <div>
                <Headers></Headers>
                <ProductForm></ProductForm>
            </div>
        )
    }
}

export default Page;