import './App.css';
import axios from 'axios';
import * as Yup from 'yup';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { NotificationManager } from 'react-notifications';
import { NotificationContainer } from 'react-notifications';
import 'react-notifications/lib/notifications.css';

function App() {

  const initialValues = {
    word: ""
  };

  const validationSchema = Yup.object().shape({
    word: Yup.string().required("*Morate uneti jednu rec")
  });

  const onSubmit = (data) => {
    axios.post("http://localhost:4000/api/check-word", JSON.stringify(data.word), {headers: {
      'Content-Type': 'application/json'
    }}).then((response) => {
      if(response.data === "correct"){
        return NotificationManager.success('', 'Rec je ispravno napisana', 6000);
      } else {
        return NotificationManager.error('Da li ste mislili: ' + response.data, 'Neispravna rec', 6000);
      }
    })
  }

  return (
    <div>
    <div className="container">
        <div className="py-5 text-center">
            <h2>Provera ispravnosti reci</h2>
        </div>
        <div className="row">
            <div className="col-12 col-lg-6 m-auto mb-5">
                <Formik initialValues={initialValues} onSubmit={onSubmit} validationSchema={validationSchema}>
                    <Form className="p-4 p-md-5 border rounded-0 bg-light">
                        <div className="col mb-3 mt-4">
                            <label htmlFor="word" className="form-label">Unesite jednu rec:</label>
                            <Field type="text" className="form-control rounded-0" id="word" name="word" placeholder="exp. Kamion" />
                            <ErrorMessage name="word" component="span" />
                        </div>
                        <button className="w-100 btn btn-lg btn-outline-success rounded-0" type="submit"><i className="fa fa-search" aria-hidden="true"></i> Proveri rec</button>
                    </Form>
                </Formik>
            </div>
        </div>
    </div>
    <NotificationContainer />
</div>
  );
}

export default App;
