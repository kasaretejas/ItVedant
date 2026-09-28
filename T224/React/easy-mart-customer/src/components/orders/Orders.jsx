import React from 'react'
import "react-datepicker/dist/react-datepicker.css";
import { useState } from "react";
import DatePicker from "react-datepicker";

export default function Orders() {
  const [selectedDate, setSelectedDate] = useState(null);

    const orders = [
        {
            order_id: 123,
            date: "2025-12-17"
        },
        {
            order_id: 124,
            date: "2025-11-18"
        }
    ];

    const enabledDates = orders.map(
        order => new Date(order.date)
    );


  return (
    <div className='container mt-5'>
      <div className='row'>
        <h3 className='col-9'>Your Orders</h3>
        <div className='col-3'>
          
            <label for="inputPassword6" class="col-form-label me-2">Order Date</label>
            {/* <input type="date" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline"/> */}
            <DatePicker
            selected={selectedDate}
            onChange={(date) => setSelectedDate(date)}
            includeDates={enabledDates}
            dateFormat="yyyy-MM-dd"
            showIcon
            icon={<i className="bi bi-calendar2 me-2"></i>}
            isClearable
            closeOnScroll
            
        />
          
        </div>
      </div>
      <hr />

      <DatePicker
            selected={selectedDate}
            onChange={(date) => setSelectedDate(date)}
            includeDates={enabledDates}
            dateFormat="yyyy-MM-dd"
            placeholderText="Select order date"
        />
    </div>
  )
}
