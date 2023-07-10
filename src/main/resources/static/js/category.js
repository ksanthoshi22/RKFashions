
  function confirmDelete(id) {
      event.preventDefault();
      if (confirm("Are you sure you want to delete this category?")) {
        window.location.href = "/admin/categories/delete/" + id;
      }
    }
