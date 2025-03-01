<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="com.medicare.model.User" %>
<jsp:include page="/pages/partials/header.jsp" />

    <%
        User user = (User) session.getAttribute("user");
        System.out.println(request.getAttribute("appointments"));
    %>

    <div class="container flex justify-between items-center mb-5 py-3 mx-auto">
        <h1 class="text-3xl">Appointments</h1>
        <a href="#" class="btn bg-blue-700 block py-3 px-6 font-bold text-white rounded">New Appointment</a>
    </div>

    <div class="container mx-auto mb-6">
            <div class="relative overflow-x-auto">
                 <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
                     <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                         <tr>
                             <th scope="col" class="px-6 py-3">
                                 #ID
                             </th>
                             <th scope="col" class="px-6 py-3">
                                  Doctor name
                             </th>
                             <th scope="col" class="px-6 py-3">
                                  doctor phone
                             </th>
                             <th scope="col" class="px-6 py-3">
                                 Date
                             </th>
                             <th scope="col" class="px-6 py-3">
                                 Time
                             </th>
                             <th scope="col" class="px-6 py-3">
                                 motif
                             </th>
                             <th scope="col" class="px-6 py-3">
                                 Actions
                             </th>
                         </tr>
                     </thead>

                     <tbody>
                          <c:forEach var="appt" items="${appointments}">
                              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 border-gray-200">
                                  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                        <c:out value="${appt.id}" />
                                  </th>
                                  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">

                                  </th>
                                  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">

                                  </th>
                                  <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">

                                  </th>
                                  <td class="px-6 py-4">

                                  </td>
                                  <td class="px-6 py-4">

                                  </td>
                                  <td class="px-6 py-4">

                                  </td>
                              </tr>
                          </c:forEach>
                     </tbody>
                 </table>
            </div>
    </div>

<jsp:include page="/pages/partials/footer.jsp" />
